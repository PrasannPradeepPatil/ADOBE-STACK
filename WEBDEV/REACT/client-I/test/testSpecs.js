
/**
 * @jest-environment jsdom
 */
import React from "react";

import '@testing-library/jest-dom'
import { render, waitFor, screen, fireEvent } from '@testing-library/react'

import '@testing-library/jest-dom'
import axios from 'axios';
import * as data from "../mocktestdata/data"
import { BrowserRouter, MemoryRouter, Route, Routes } from "react-router-dom";
import AccountList from "../src/components/AccountList/account-list";
import ClusterList from "../src/components/ClusterList/clusters-list";
import ServicesList from '../src/components/ServicesList/services-list';

jest.mock('axios')

beforeAll(() => {
    process.env.API_URL = "http://localhost:8083";
})


describe('Testing Account List Component', () => {


    test('test accounts list component for normal scenario', async () => {
        axios.get.mockResolvedValueOnce(data.test_account_data);
        render(<BrowserRouter><AccountList /></BrowserRouter>);
        await waitFor(() => expect(screen.getByText("aws-iat-development")).toBeInTheDocument())
    })

    test('test account list component for empty response', async () => {
        axios.get.mockResolvedValueOnce(data.empty_test_account_data);
        render(<BrowserRouter><AccountList /></BrowserRouter>);
        await waitFor(() => expect(screen.getByText("No Accounts Found")).toBeInTheDocument())
    })

    test('test account list for error response', async () => {
        axios.get.mockRejectedValueOnce(new Error('Timeout error'))
        render(<BrowserRouter><AccountList /></BrowserRouter>);
        await waitFor(() => expect(screen.getByText("Could Not Retrieve List Of Accounts")).toBeInTheDocument())
        await waitFor(() => expect(screen.queryByText("Accounts")).not.toBeInTheDocument())
    })
})


describe('Testing Cluster List Component', () => {
    test('test cluster list component for normal scenario', async () => {
        axios.get.mockResolvedValueOnce(data.test_cluster_data);
        render(<MemoryRouter initialEntries={['/clusters/aws_accounts/aws-iat-development']}>
            <Routes>
                <Route path='/clusters/:parent/:account' element={<ClusterList />}>
                </Route>
            </Routes>
        </MemoryRouter>);
        await waitFor(() => expect(screen.getByText("Clusters deployed for account : aws-iat-development")).toBeInTheDocument())
        await waitFor(() => expect(screen.getByText("githubrunner-prod-us-east-1-eks")).toBeInTheDocument())
    })

    test('test cluster list component for empty response scenario', async () => {
        axios.get.mockResolvedValueOnce(data.empty_test_cluster_data);
        render(<MemoryRouter initialEntries={['/clusters/aws_accounts/aws-iat-development']}>
            <Routes>
                <Route path='/clusters/:parent/:account' element={<ClusterList />}>
                </Route>
            </Routes>
        </MemoryRouter>);
        await waitFor(() => expect(screen.getByText("No clusters have been deployed for the account -")).toBeInTheDocument())
        await waitFor(() => expect(screen.getByText("aws-iat-development")).toBeInTheDocument())
    })

    test('test cluster list component for error scenario', async () => {
        axios.get.mockRejectedValueOnce(new Error('Timeout error'))
        render(<MemoryRouter initialEntries={['/clusters/aws_accounts/aws-iat-development']}>
            <Routes>
                <Route path='/clusters/:parent/:account' element={<ClusterList />}>
                </Route>
            </Routes>
        </MemoryRouter>);
        await waitFor(() => expect(screen.getByText("Could not retrieve clusters deployed for the account : aws-iat-development")).toBeInTheDocument())
    })
})

describe('Testing platform List Component', () => {
    test('test platform list component for normal scenario', async () => {
        axios.get.mockResolvedValueOnce(data.test_services_data)
        render(<MemoryRouter initialEntries={['/services/aws_accounts/aws-iat-githubrunner-prod/githubrunner-prod-us-east-1-eks']}>
            <Routes>
                <Route path='/services/:parent/:account/:cluster' element={<ServicesList />}>
                </Route>
            </Routes>
        </MemoryRouter>);
        await waitFor(() => expect(screen.getByText("Services deployed for cluster : githubrunner-prod-us-east-1-eks")).toBeInTheDocument())
        await waitFor(() => expect(screen.getByText("kube-proxy")).toBeInTheDocument())
    })

    test('test platform list component for empty response scenario', async () => {
        axios.get.mockResolvedValueOnce(data.empty_test_services_data);
        render(<MemoryRouter initialEntries={['/services/aws_accounts/aws-iat-githubrunner-prod/githubrunner-prod-us-east-1-eks']}>
            <Routes>
                <Route path='/services/:parent/:account/:cluster' element={<ServicesList />}>
                </Route>
            </Routes>
        </MemoryRouter>);
        await waitFor(() => expect(screen.getByText("No services have been installed on the cluster :")).toBeInTheDocument())
        await waitFor(() => expect(screen.getByText("githubrunner-prod-us-east-1-eks")).toBeInTheDocument())
    })

    test('test platform list component for error scenario', async () => {
        axios.get.mockRejectedValueOnce(data.empty_test_cluster_data);
        render(<MemoryRouter initialEntries={['/services/aws_accounts/aws-iat-githubrunner-prod/githubrunner-prod-us-east-1-eks']}>
            <Routes>
                <Route path='/services/:parent/:account/:cluster' element={<ServicesList />}>
                </Route>
            </Routes>
        </MemoryRouter>);
        await waitFor(() => expect(screen.getByText("Could Not Retrieve Platform Services Installed On Cluster Named : githubrunner-prod-us-east-1-eks")).toBeInTheDocument())
        await waitFor(() => expect(screen.queryByText("Services deployed for cluster : githubrunner-prod-us-east-1-eks")).not.toBeInTheDocument())
    })
})

describe('Testing Transition Between Pages', () => {
    test('testing transiion between pages', async () => {
        axios.get.mockResolvedValueOnce(data.test_account_data)
        render(<MemoryRouter initialEntries={['/']}>
            <Routes>
                <Route path='/' element={<AccountList />}></Route>
                <Route path='/clusters/:parent/:account/' element={<ClusterList />}></Route>
                <Route path='/services/:parent/:account/:cluster' element={<ServicesList />}></Route>
            </Routes>
        </MemoryRouter>);

        //wait for accounts list component to load
        await waitFor(() => expect(screen.getByText("aws-iat-development")).toBeInTheDocument())
        axios.get.mockResolvedValueOnce(data.test_cluster_data)
        
        //emulate click on accounts list component and wait for clusters list component to load
        fireEvent.click(screen.getByText("aws-iat-development"))
        await waitFor(() => expect(screen.getByText("Clusters deployed for account : aws-iat-development")).toBeInTheDocument())
        await waitFor(() => expect(screen.getByText("githubrunner-prod-us-east-1-eks")).toBeInTheDocument())
        
        //emulate click on cluster list component and wait for services list component to load
        axios.get.mockResolvedValueOnce(data.test_services_data)
        fireEvent.click(screen.getByText("githubrunner-prod-us-east-1-eks"))
        await waitFor(() => expect(screen.getByText("Services deployed for cluster : githubrunner-prod-us-east-1-eks")).toBeInTheDocument())
        await waitFor(() => expect(screen.getByText("kube-proxy")).toBeInTheDocument())
    })
})


