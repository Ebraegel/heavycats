import './App.css';
import axios from 'axios';
import React, { useState, useEffect } from 'react'

function App() {
  const [cats, setCats] = useState([]);
  const [catName, setCatName] = useState("");

  const getCats = async () => {
    const response = await axios.get('/cats/')
    console.log('cats:');
    console.log(response.data);
    setCats(response.data)
  }

  useEffect(() => {
    getCats()
  }, [])

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/cats', { name: catName.trim() })
      if (response.status) {
        getCats();
      }
    } catch (err) {
      alert('Error - cat could not be added!');
    }
  }

  return (
    <div className="App">
      <h1>Cats</h1>
      <form onSubmit={handleSubmit} id="new-cat-form">
        <input
          id="catName"
          placeholder="Name"
          value={catName}
          onChange={e => setCatName(e.target.value)}
        />
        <button type="submit">Add Cat</button>
      </form>
      <hr></hr>
      <table align="center">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
          </tr>
        </thead>
        <tbody>
          {
            cats.map((cat) => {
              return (
                <tr key={cat.id}>
                  <td>{cat.id}</td>
                  <td>{cat.name}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  );
}

export default App;
