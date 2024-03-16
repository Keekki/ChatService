import PropTypes from 'prop-types'; // Lisää tämä rivi
import { useState } from 'react';

import CommentSection from './CommentSection';
import ImageSection from './ImageSection';

const Post = ({ title, imageSrc, description }) => {
  const [likes, setLikes] = useState(0);

  const handleLike = () => {
    setLikes(likes + 1);
  };

  return (
    <div className="post-container">
      <h2>{title}</h2>
      <ImageSection imageSrc={imageSrc} />
      <div>
        <p>{description}</p>
      </div>
      <div className="like-comment-container">
        <div className="like-section">
          <button onClick={handleLike}>Tykkää</button>
        </div>
        <div className="like-count">
          <p>Tykkäykset: {likes}</p>
        </div>
      </div>
      <CommentSection />
    </div>
  );
};

// Lisää prop-tyyppien validointi
Post.propTypes = {
  title: PropTypes.string.isRequired,
  imageSrc: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
};

export default Post;
