import React from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Cats from './components/Cats'
import CatDetail from './components/CatDetail'

function App() {
  return (
    <Router>
      <div id="app">
        <Switch>
          <Route exact path='/ui/cats' component={Cats} />
          <Route exact path='/ui/cats/:id' component={CatDetail} />
          <Route path='/' component={Cats}/>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
