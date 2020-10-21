import { ProductType } from './ProductType';
export interface Product {
    id: number;
    proCode: string;
    name: string;
    image: String;
    price: number;
    productType: ProductType;
    proTypeId: number;
    dateCreated: Date;
    dateModified: Date;
    createdBy: string;
    modifiedBy: string;
    description: string;
}

