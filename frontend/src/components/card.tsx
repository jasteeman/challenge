import React from 'react';
import { Frase } from '../interfaces/IFrase';

interface CardProps {
  frase: Frase;
  eliminarFrase: (id: number) => void;
}

const Card = ({ frase, eliminarFrase }: CardProps) => { 
    return (
      <div className="bg-white p-4 m-2 rounded shadow-lg w-60">
        <p className="text-gray-800">{frase.texto}</p>
        <button
          onClick={() => eliminarFrase(frase.id)}
          className="mt-2 bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600"
        >
          Eliminar
        </button>
      </div>
    );
  };
export default Card;
