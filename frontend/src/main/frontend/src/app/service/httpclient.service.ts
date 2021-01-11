import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

export class UserAccount {
  constructor(
    public id: string,
    public username: string,
    public password: string,
    public surname: string,
    public lastname: string,
    public email: string
  ) {
  }
}

@Injectable({
  providedIn: 'root'
})
export class HttpclientService {

  constructor(private httpClient: HttpClient) {
  }

  getUsers() {
    const basicString = this.getHeaders();

    const headers = new HttpHeaders(
      {Authorization: basicString}
    );
    console.log('test call');
    return this.httpClient.get<UserAccount[]>('http://localhost:8080/users', {headers});
  }

  public createUsers(employee) {
    return this.httpClient.post<UserAccount>('http://localhost:8080/users', employee);
  }


  getHeaders() {
    const username = 'admin';
    const password = 'password';

    const basicString = 'Basic ' + window.btoa(username + ':' + password);
    return basicString;
  }
}
