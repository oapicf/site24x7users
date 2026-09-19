import flask
from typing import Dict
from typing import Tuple
from typing import Union

from openapi_server import util


def search(q):  # noqa: E501
    """Search with a query

     # noqa: E501

    :param q: 
    :type q: str

    :rtype: Union[str, Tuple[str, int], Tuple[str, int, Dict[str, str]]
    """
    return 'do some magic!'
