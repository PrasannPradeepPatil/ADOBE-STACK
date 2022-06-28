
//IMPORT EXTERNAL MODULE
import { combineReducers } from 'redux';         //sudo npx create-react-app client
//IMPORT MODULE
import posts from './posts';


//COMBINERS
/*
export const reducers = combineReducers({ posts });--update the state in reduxStore(posts) to newState returned by action(posts)
 */
export const reducers = combineReducers({ posts:posts });