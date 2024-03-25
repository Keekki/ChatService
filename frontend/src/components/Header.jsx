// Header.jsx
import React from "react";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faRightToBracket, faUser } from "@fortawesome/free-solid-svg-icons";
// import { UserContext } from "./users/UserContext";
import "../styling/Header.css";

const Header = () => {
  // const { user, setUser, logoutUser } = useContext(UserContext);
  // const location = useLocation();

  // const handleLogout = () => {
  //   logoutUser();
  // };

  return (
    <header className="header">
      <Link to="/" className="logo-link">
        <img src="../../public/logo2.png" alt="WAT" />
      </Link>
      <nav>
        <ul className="nav-links">
          <li>
            <Link to="/category">Category</Link>
          </li>
          <li className="login-li">
            {/* {user ? (
              <div className="user-menu">
                {user.name}
                <FontAwesomeIcon icon={faUser} className="login-icon" />
              </div>
            ) : ( */}
            <a href="http://localhost:8081/login" className="login-link">
              Log In
              <FontAwesomeIcon icon={faRightToBracket} className="login-icon" />
            </a>
            {/* )} */}
          </li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
