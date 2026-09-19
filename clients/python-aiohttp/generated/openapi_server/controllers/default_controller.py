from typing import List, Dict
from aiohttp import web

from openapi_server import util


async def search(request: web.Request, q) -> web.Response:
    """Search with a query

    

    :param q: 
    :type q: str

    """
    return web.Response(status=200)
