import { Body, Controller, DefaultValuePipe, Get, Param, ParseIntPipe, ParseFloatPipe, Query, Req } from '@nestjs/common';
import { Observable } from 'rxjs';
import { Cookies, Headers } from '../decorators';
import { DefaultApi } from '../api';

@Controller()
export class DefaultApiController {
  constructor(private readonly defaultApi: DefaultApi) {}

  @Get('/search')
  search(@Query('q') q: string, @Req() request: Request): string | Promise<string> | Observable<string> {
    return this.defaultApi.search(q, request);
  }

} 