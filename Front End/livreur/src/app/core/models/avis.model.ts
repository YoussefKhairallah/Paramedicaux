import { Produit } from "./produit.model";
import { User } from "./user.model";

export interface Avis {
    id: number;
    Description: string;
    Date: string;
    Client: User;
    Produit: Produit;
}