import { User } from "./auth.models";

export class Commande {
    id: number;
    adresse: String;
    date: string;
    etat: string;
    prix_totale: string;
    id_client: User;
}