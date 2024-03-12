import { Car } from "./car.model";
import { User } from "./user.model";

export class Visit{

    constructor(
        public visit_id:number, 
        public dateTime:Date, 
        public car_id:Car,
        public buyer:User,        
        ){

    }

}