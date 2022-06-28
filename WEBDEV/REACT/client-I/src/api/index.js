//IMPORT EXTERNAL MODULE
import axios from 'axios';   //sudo npm install axios


//API FN SEND; API FN RECEIVE
/*
const baseUrl = 'http://localhost:5000/posts'
export const createPost = (arg)     => axios.post(url, data);                -->For baseURL/endpoint ;send and receive data for create operation 
export const getPosts   = ()         => axios.get(url);                        get()   --send id ;add id to DB; and receive body
export const updatePost = (id,arg)   => axios.patch(`${url}/${id}`,arg);       put()   --send body and id;update body acc to ID in DB; receive body(Entire resource)
export const deletePost = (id,arg)   => axios.delete(`${url}/${id}`);          patch() --send body and id;update body acc to ID in DB; receive body(Required part)
                                                                               post()  --send body ;add body to DB; and receive body
                                                                               delete()--send body and id;delete body acc to ID in DB; receive body

*/

const BaseUrl = 'http://localhost:5000/posts';
export const createPost = (newPost) => axios.post(BaseUrl, newPost);
export const getPosts   = () => axios.get(BaseUrl);
export const likePost   = (id) => axios.patch(`${BaseUrl}/${id}/likePost`);
export const updatePost = (id, updatedPost) => axios.patch(`${BaseUrl}/${id}`, updatedPost);
export const deletePost = (id) => axios.delete(`${BaseUrl}/${id}`);


