import { ServiceType } from './ServiceType';
export interface Service {
    id: number;
    serCode: string;
    name: string;
    image: string;
    price: number;
    serviceType: ServiceType;
    serviceId: number;
}