import React, { useState, useEffect } from "react";
import "../styling/ProfilePage.css";

const ProfilePage = () => {
  const [name, setName] = useState("");
  const [bio, setBio] = useState("");

  useEffect(() => {
    fetch("/api/user")
      .then((response) => response.json())
      .then((data) => {
        setName(data.name);
        setBio(data.bio);
      })
      .catch((error) => console.error("Error fetching user data:", error));
  }, []);

  return (
    <div className="profile-page">
      <div className="posts"></div>
      <div className="profile">
        <div className="profileName">
          <p>Name here</p>
        </div>
        <div className="profileData">
          <p>Bio here</p>
        </div>
      </div>
    </div>
  );
};

export default ProfilePage;
