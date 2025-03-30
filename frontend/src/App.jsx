import { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { agregarFrase, eliminarFrase, filtrarFrases } from './redux/actions/fraseActions';
import Filtro from './components/filtro';
import Card from './components/card';
import './App.css'


const App = () => {
  const dispatch = useDispatch();
  const frasesFiltradas = useSelector((state) => state.frases.frasesFiltradas);
  const [newFrase, setNewFrase] = useState(''); 

  const newItem = () => {
    if (newFrase.trim()) {
      newFrase
      dispatch(agregarFrase({id:frasesFiltradas.length++,texto:newFrase}));
      setNewFrase('');
    }
  };

  const manejarFiltro = (texto) => {
    dispatch(filtrarFrases(texto));
  };

 
  return (
    <div className="max-w-4xl mx-auto p-4">
      <h1 className="text-3xl font-semibold text-center mb-6">Aplicación de Frases</h1>
      <Filtro onFiltrar={manejarFiltro} />
      <div className="mb-4 flex">
        <input
          type="text"
          value={newFrase}
          onChange={(e) => setNewFrase(e.target.value)}
          placeholder="Agregar nueva frase"
          className="p-2 border border-gray-300 rounded w-full mr-2"
        />
        <button
          onClick={newItem}
          className="bg-blue-500 text-white px-6 py-2 rounded hover:bg-blue-600"
        >
          Agregar Frase
        </button>
      </div>
      <div className="flex flex-wrap">
        {frasesFiltradas.map((frase, index) => (
          <Card
            key={index}
            frase={frase}
            eliminarFrase={() => dispatch(eliminarFrase(index))}
          />
        ))}
      </div>
    </div>
  );
};
 
export default App;
