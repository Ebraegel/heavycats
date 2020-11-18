import './Weights.css'
import axios from 'axios';
import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'


export default function CatDetail(props) {
    const [weights, setWeights] = useState([]);
    const [cat, setCat] = useState({});
    const [weight, setWeight] = useState();

    let { id } = useParams();

    const getCat = async () => {
        const response = await axios.get(`/cats/${id}`)
        console.log('cat:');
        console.log(response.data);
        setCat(response.data)
    }

    useEffect(() => {
        getCat()
    }, [])


    const getWeights = async () => {
        const response = await axios.get(`/cats/${id}/weights`)
        console.log('weights:');
        console.log(response.data);
        setWeights(response.data)
    }

    useEffect(() => {
        getWeights()
    }, [])

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post(`/cats/${cat.id}/weights`, { weight: weight.trim() })
            if (response.status) {
                getWeights();
            }
        } catch (err) {
            alert('Error - weight could not be added!');
        }
    }

    return (
        <div id="weights">
            <div className="breadcrumb"><a href='/cats'>cats</a> / {cat.name}</div>
            <h1>{cat.name || ''}</h1>
            <form onSubmit={handleSubmit} id="new-weight-form">
                <input
                    id="catWeight"
                    placeholder="Weight"
                    value={weight}
                    onChange={e => setWeight(e.target.value)}
                />
                <button type="submit">Add Weight</button>
            </form>
            <hr></hr>
            { weights.length === 0 ? 'No weights recorded yet' : (
                <table align="center">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Weight</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            weights.map((weight) => {
                                return (
                                    <tr key={weight.id}>
                                        <td>{weight.createdAt}</td>
                                        <td>{weight.weight}</td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>
            )
            }
        </div>
    )

}
