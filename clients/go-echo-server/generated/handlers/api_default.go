package handlers
import (
	"github.com/null/null/models"
	"github.com/labstack/echo/v4"
	"net/http"
)

// Search - Search with a query
func (c *Container) Search(ctx echo.Context) error {
	return ctx.JSON(http.StatusOK, models.HelloWorld {
		Message: "Hello World",
	})
}

