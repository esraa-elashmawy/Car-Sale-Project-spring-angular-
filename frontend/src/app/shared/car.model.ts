export class Car{

    constructor( 
        public car_id: number,
        public brand:string, 
        public model:string,
        public km: number,
        public year: number,        
        public type: carType,
        public inspectionReport:string,
        public price: number,
        public picture:string="https://png.pngtree.com/element_our/sm/20180516/sm_5afbf1d28feb1.jpg", 

        ){

    }

    

}
export enum carType {
  Automatic,
  Manual
}