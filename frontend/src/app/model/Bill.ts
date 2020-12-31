import { Product } from './Product';

export interface Bill {
    productList: Product[];
    quantity: number[];
    contact: String;
    total: number;
}
