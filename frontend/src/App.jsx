import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import './App.css';
import NavigationBar from './NavigationBar';
import Post from './Post';

const Home = () => {
  return (
    <div>
      <Post
        title="Otsikko 1"
        imageSrc="https://www.html.am/images/html-codes/links/boracay-white-beach-sunset-300x225.jpg"
        description="Kuvateksti 1"
      />
      <Post
        title="Otsikko 2"
        imageSrc="https://www.html.am/images/html-codes/links/boracay-white-beach-sunset-300x225.jpg"
        description="Kuvateksti 2"
      />
    </div>
  );
};

const App = () => {
  return (
    <Router>
      <div className="App">
        <div className="navigation-container">
          <NavigationBar />
        </div>
        <div className="content-container">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" />
          </Routes>
        </div>
      </div>
    </Router>
  );
};

export default App;
