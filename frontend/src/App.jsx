import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ProfilePage from "./pages/ProfilePage.jsx";
import Header from "./components/Header.jsx";
import "./App.css";

const Home = () => {
  <div>Home</div>;
};

const App = () => {
  return (
    <Router>
      <div className="App">
        <Header />

        <div className="content-container">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/user" element={<ProfilePage />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
};

export default App;
