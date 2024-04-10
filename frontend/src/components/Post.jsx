import React from "react";
import { Link } from "react-router-dom";
import "../styling/Post.css";

const Post = ({ text, image, userId, user }) => {
  return (
    <div className="post">
      <div className="user">
        <Link to={`/user/${userId}`}>{user}</Link>
      </div>
      <div className="content">
        {image && <img src={image} alt="Post Image" />}
        <p className="contentText">{text}</p>
      </div>
    </div>
  );
};

export default Post;
