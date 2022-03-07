
import { Component } from '@angular/core';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {


  vCardData:string="";
  firstName: string = '';
  size = "200"
  lastName=""
  companyName=""
  address=""
  email=""
  mobile=""
  
  
  generate(){
   
   this.vCardData = "BEGIN:VCARD\r\nVERSION:2.1\r\nN:" + this.lastName +"\r\nFN:"+ this.firstName +"\r\nORG:" + this.companyName +
   "\r\nADR;HOME:" +  this.address+ "\r\nTEL;\r\nTYPE=cell:" + this.mobile+
   "\r\nEMAIL;PREF;INTERNET:" + this.email+ "\r\nEND:VCARD"

  }

  

}