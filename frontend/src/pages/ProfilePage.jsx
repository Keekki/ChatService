import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import Post from "../components/Post.jsx";
import testImage from "../assets/test.png";
import "../styling/ProfilePage.css";

const ProfilePage = () => {
  const { idUser } = useParams();
  const [userName, setName] = useState("");
  const [bio, setBio] = useState("");
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    fetch(`localhost:8081/user/${id}`)
      .then((response) => response.json())
      .then((data) => {
        if (data.userName && data.bio) {
          setName(data.userName);
          setBio(data.bio);
        }
      })
      .catch(
        (error) => console.error("Error fetching user data:", error),
        setName("Default Dummy"),
        setBio("Nothing to see here.")
      );
  }, []);

  useEffect(() => {
    fetch("localhost:8081/posts")
      .then((response) => response.json())
      .then((data) => {
        setPosts(data);
      })
      .catch((error) => {
        console.error("Error fetching posts:", error);
      });
  }, []);

  return (
    <div className="profile-page">
      <div className="posts">
        {posts.length === 0 ? (
          <Post
            key="dummy"
            user="Default Dummy"
            text="Dummy test text that is only here to make sure if things are working. Also helps with styling etc."
            image={testImage}
          />
        ) : (
          posts.map((post) => (
            <Post
              key={post.id}
              userId={idUser}
              text={post.text}
              image={post.image}
            />
          ))
        )}
      </div>
      <div className="profile">
        <div className="profileName">
          <p>{userName}</p>
        </div>
        <div className="profileData">
          <p>{bio}</p>
        </div>
      </div>
    </div>
  );
};

export default ProfilePage;
