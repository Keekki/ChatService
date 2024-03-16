import { useState } from 'react';

const CommentSection = () => {
  const [comments, setComments] = useState([]);
  const [newComment, setNewComment] = useState('');

  const handleCommentChange = (event) => {
    setNewComment(event.target.value);
  };

  const handleAddComment = () => {
    setComments([newComment, ...comments]);
    setNewComment('');
  };

  return (
    <div className="comment-section">
      <h3>Vastaukset</h3>
      <ul>
        {comments.map((comment, index) => (
          <li key={index}>{comment}</li>
        ))}
      </ul>
      <textarea value={newComment} onChange={handleCommentChange} placeholder="Kirjoita vastauksesi" />
      <button onClick={handleAddComment}>Lisää vastaus</button>
    </div>
  );
};

export default CommentSection;
