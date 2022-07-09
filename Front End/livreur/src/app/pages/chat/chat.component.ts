import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { AngularFireStorage } from '@angular/fire/storage';
import { FormBuilder, Validators, FormGroup, FormArray } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Messages } from 'src/app/core/models/messages';
import { User } from 'src/app/core/models/user.model';
import { UserService } from 'src/app/core/services/auth/user.service';
import { MessagesService } from 'src/app/core/services/Ecommerce/Message/messages.service';

import { ChatUser, ChatMessage } from './chat.model';

import { chatData, chatMessagesData } from './data';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss'],
})
export class ChatComponent implements OnInit, AfterViewInit {
  @ViewChild('scrollEle') scrollEle;
  @ViewChild('scrollRef') scrollRef;

  username = 'Steven Franklin';

  // bread crumb items
  breadCrumbItems: Array<{}>;
  user:User;
  users?:User[];
    selected;
    downloadURL: Observable<string>;
    selectedFile: File = null;
    userForm: FormGroup;
    fb = "";
    innersearch: any = '';
    public query: any = '';
  p: number = 1;
msg:Messages;
    prcentage: number;
  pass:string;
    percentage: Observable<number>;
    items: FormArray;
    selectValue: string[];
    submitted = false;
  chatData: ChatUser[];
  chatMessagesData: ChatMessage[];

  formData: FormGroup;

  // Form submit
  chatSubmit: boolean;
id:string;
sub;
nom:string;
  usermessage: string;
messages:Messages[];
  constructor(private storage: AngularFireStorage,private userService:UserService,private messagesService:MessagesService,public formBuilder: FormBuilder,private route : ActivatedRoute) {
  }
  ngOnInit() {
    this.msg=new Messages();

        this.sub = this.route.queryParams.subscribe(params => {
          this.id = params['id'];
          this.nom = params['nom'];
          this.username=this.nom;
          console.log("id",this.id);
          localStorage.setItem("usid",this.id);
          this.readmessages(this.id,this.nom);
          this.breadCrumbItems = [{ label: this.nom }, { label: 'Chat', active: true }];
      });

    this.readusers();
        this.formData = this.formBuilder.group({
          message: ['', [Validators.required]],
        });

        this.onListScroll();

      //  this._fetchData();
      }
  ngAfterViewInit() {
    this.scrollEle.SimpleBar.getScrollElement().scrollTop = 100;
    this.scrollRef.SimpleBar.getScrollElement().scrollTop = 200;
  }

  /**
   * Returns form
   */
  get form() {
    return this.formData.controls;
  }

  private _fetchData() {
    this.chatData = chatData;
    this.chatMessagesData = chatMessagesData;
  }

  onListScroll() {
    if (this.scrollRef !== undefined) {
      setTimeout(() => {
        this.scrollRef.SimpleBar.getScrollElement().scrollTop =
          this.scrollRef.SimpleBar.getScrollElement().scrollHeight + 1500;
      }, 500);
    }
  }

  chatUsername(name) {
    this.username = name;
    this.usermessage = 'Hello';
    this.chatMessagesData = [];
    const currentDate = new Date();

    this.chatMessagesData.push({
      name: this.username,
      message: this.usermessage,
      time: currentDate.getHours() + ':' + currentDate.getMinutes()
    });

  }
  readusers(){
    this.userService.getUsers()
    .subscribe(data=>{
      this.users=data;
      console.log("users",data)
    })
  }
  readmessages(id,nom): void {
console.log("identifiant",id);
    let recieve=this.messagesService.read_Messages(id);


    recieve.pipe(
        map(changes =>
          changes.map(c =>
            ({ id: c.payload.doc.id,
              ...c.payload.doc.data() as {} })
          )
        )
      ).subscribe(data => {

          this.messages = data;


        console.log("messages",this.messages);
      }
      );

  }
  /**
   * Save the message in chat
   */
   messageSave(type) {
    this.sub = this.route.queryParams.subscribe(params => {
      this.id = params['id'];
      this.nom = params['nom'];
      this.username=this.nom;
      console.log("id",this.id);
      const message = this.formData.get('message').value;
      const currentDate = Date.now();
      this.msg.date=currentDate;
      this.msg.senderUsername="admin";
      let us=JSON.parse(localStorage.getItem("userInfo")) as User;
      this.msg.senderid=us.id.toString();

      if (this.formData.valid && message) {
        this.msg.texte=message;
        this.msg.type=type;
        this.msg.recieverUsername=this.username;
        this.msg.recieverid=this.id;
let ms=Object.assign({},this.msg);
this.messagesService.create_NewMessage(ms,this.id);

        this.onListScroll();

        // Set Form Data Reset
        this.formData = this.formBuilder.group({
          message: null
        });
      }

      this.chatSubmit = true;  });

  }

}
