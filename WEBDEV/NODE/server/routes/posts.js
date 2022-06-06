//IMPORT EXTERNAL MODULE
var express = require('express');
//IMPORT MODULE
var {getPosts,getPost, createPost, updatePost, likePost, deletePost } = require('../controllers/posts')

const router = express.Router();


//ROUTE FN
/* #region Main */
/*


              
router.post('/', createPost);            -->For baseURL/endpoint ;send and receive data for create operation 
router.get('/', getPosts);                 get()   --send id ;add id to DB; and receive body
router.get('/:id', getPost);               put()   --send body and id;update body acc to ID in DB; receive body(Entire resource)
router.patch('/:id', updatePost);          patch() --send body and id;update body acc to ID in DB; receive body(Required part)
router.delete('/:id', deletePost);         post()  --send body ;add body to DB; and receive body
router.patch('/:id/likePost', likePost);   delete()--send body and id;delete body acc to ID in DB; receive body

*/
/* #endregion */

router.post('/', createPost);
router.get('/', getPosts);
router.get('/:id', getPost);
router.patch('/:id', updatePost);
router.delete('/:id', deletePost);
router.patch('/:id/likePost', likePost);


//EXPORT
module.exports = router;


