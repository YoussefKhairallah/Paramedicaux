import { Commande } from "./Commande.model";
import { Produit } from "./produit.model";

export interface DetailCommande {
    id: number;
    qte: number;
    total: number;
    commande: Commande;
    produit: Produit;
}