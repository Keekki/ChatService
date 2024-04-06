import React, { useState, useEffect } from "react";
import Post from "../components/Post.jsx";
import testImage from "../assets/test.png";
import "../styling/ProfilePage.css";

const ProfilePage = () => {
  const [name, setName] = useState("");
  const [bio, setBio] = useState("");
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    fetch("localhost:8081/user")
      .then((response) => response.json())
      .then((data) => {
        if (data.name && data.bio) {
          setName(data.name);
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
        setPosts([
          {
            id: "dummy",
            user: "Default Dummy",
            text: "Dummy test text that is only here to make sure if things are working. Also helps with styling etc.",
            image: testImage,
          },
        ]);
      });
  }, []);

  return (
    <div className="profile-page">
      <div className="posts">
        {posts.map((post) => (
          <Post
            key={post.id}
            user={post.user}
            text={post.text}
            image={post.image}
          />
        ))}
      </div>
      <div className="profile">
        <div className="profileName">
          <p>{name}</p>
        </div>
        <div className="profileData">
          <p>{bio}</p>
        </div>
      </div>
    </div>
  );
};

export default ProfilePage;
