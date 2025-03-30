import { Frase } from "../../interfaces/IFrase";


export const AGREGAR_FRASE = 'AGREGAR_FRASE';
export const FILTRAR_FRASES = 'FILTRAR_FRASES';
export const ELIMINAR_FRASE = 'ELIMINAR_FRASE';

export interface AgregarFraseAction {
  type: typeof AGREGAR_FRASE;
  payload: Frase;
}

export interface FiltrarFrasesAction {
  type: typeof FILTRAR_FRASES;
  payload: string;
}

export interface EliminarFraseAction {
  type: typeof ELIMINAR_FRASE;
  payload: number;
}

export type FraseActionTypes = AgregarFraseAction | FiltrarFrasesAction | EliminarFraseAction;

export const agregarFrase = (frase: Frase): AgregarFraseAction => ({
  type: AGREGAR_FRASE,
  payload: frase,
});

export const filtrarFrases = (texto: string): FiltrarFrasesAction => ({
  type: FILTRAR_FRASES,
  payload: texto,
});

export const eliminarFrase = (id: number): EliminarFraseAction => ({
  type: ELIMINAR_FRASE,
  payload: id,
});
