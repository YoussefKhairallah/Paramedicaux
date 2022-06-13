export interface User {
    id: number;
    nom: string;
    prenom: string;
    dateNaissance: string;
    tel: string;
    email: string;
    password: string;
    codePostal: String;
    image: String;
    pays: String;
    ville: String;
    //username: string;
    state: string;
    roles: number;
    accessToken: string;
}