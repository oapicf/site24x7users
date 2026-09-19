using Org.OpenAPITools.Models;

namespace Org.OpenAPITools.Features;



/// <summary>
/// Search with a query
/// </summary>

public class SearchEndpoint : FastEndpoints.Endpoint<SearchRequest, string>
{
    public override void Configure()
    {
        Get("/search");
        
        
        AllowAnonymous();
        
        Description(x =>
        {
            x.WithTags("default");
        });

        Summary(s => {
            s.Summary = "Search with a query";
            s.RequestParam(r => r.Q, "");
            s.Responses[200] = "Search HTML response";
        });
    }

    public override async Task HandleAsync(SearchRequest req, CancellationToken ct)
    {
        //Response = new()
        //{
            //...
        //};
        //return Task.CompletedTask;
    }
}

