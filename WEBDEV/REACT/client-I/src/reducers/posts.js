const CREATE = 'CREATE';
const UPDATE = 'UPDATE';
const DELETE = 'DELETE';
const FETCH_ALL = 'FETCH_ALL';
const LIKE = 'LIKE';

//REDUCERS
/* #region Main */
/*
const reducer = (posts = [], action) => {   --> Based on actionType create newState(newPosts) 
  let newPosts = []                             
  switch (action.type) {                       
    case FETCH_ALL:
      newPosts =  action.payload;
    case LIKE:
      newPosts =  posts.map((post) => (post._id === action.payload._id ? action.payload : post));
    case CREATE:
      newPosts =  [...posts, action.payload];
    case UPDATE:
      newPosts =  posts.map((post) => (post._id === action.payload._id ? action.payload : post));
    case DELETE:
      newPosts =  posts.filter((post) => post._id !== action.payload);
    default:
      return newPosts;

    return newPosts;
  }
};

export default reducer;

*/
/* #endregion */


export default (posts = [], action) => {
  let newPosts = []
  switch (action.type) {
    case FETCH_ALL:
      newPosts =  action.payload;
    case LIKE:
      newPosts =  posts.map((post) => (post._id === action.payload._id ? action.payload : post));
    case CREATE:
      newPosts =  [...posts, action.payload];
    case UPDATE:
      newPosts =  posts.map((post) => (post._id === action.payload._id ? action.payload : post));
    case DELETE:
      newPosts =  posts.filter((post) => post._id !== action.payload);
    default:
      newPosts =  newPosts;

    return newPosts;
  }
};


