import { Injectable } from '@nestjs/common';
import { Observable } from 'rxjs';


@Injectable()
export abstract class DefaultApi {

  abstract search(q: string,  request: Request): string | Promise<string> | Observable<string>;

} 