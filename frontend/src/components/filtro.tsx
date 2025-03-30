// src/components/Filtro.tsx
import React from 'react';

interface FiltroProps {
  textoFiltro: string;
  onFiltrar: (texto: string) => void;
}

const Filtro: React.FC<FiltroProps> = ({ textoFiltro, onFiltrar }) => {
  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    onFiltrar(e.target.value);
  };

  return (
    <div className="mb-4">
      <input
        type="text"
        value={textoFiltro}
        onChange={handleChange}
        placeholder="Filtrar frases"
        className="p-2 border border-gray-300 rounded w-full"
      />
    </div>
  );
};

export default Filtro;
