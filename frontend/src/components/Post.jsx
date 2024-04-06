import React from "react";
import "../styling/Post.css";

const Post = ({ text, image, user }) => {
  return (
    <div className="post">
      <div className="user">
        <p>{user}</p>
      </div>
      <div className="content">
        <img src={image} alt="Post Image" />
        <p className="contentText">{text}</p>
      </div>
    </div>
  );
};

export default Post;
