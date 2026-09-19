
using Org.OpenAPITools.Models;

namespace Org.OpenAPITools.Features;


public class SearchRequest
{
    /// <summary>
    /// 
    /// </summary>
    [FastEndpoints.QueryParam, FastEndpoints.BindFrom("q")]
    public string Q { get; set; }
}


