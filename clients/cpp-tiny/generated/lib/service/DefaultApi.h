#ifndef TINY_CPP_CLIENT_DefaultApi_H_
#define TINY_CPP_CLIENT_DefaultApi_H_


#include "Response.h"
#include "Arduino.h"
#include "Service.h"
#include "Helpers.h"
#include <list>


namespace Tiny {

/**
 *  Class 
 * Generated with openapi::tiny-cpp-client
 */

class DefaultApi : public Service {
public:
    DefaultApi() = default;

    virtual ~DefaultApi();

    /**
    * Search with a query.
    *
    * 
    * \param q  *Required*
    */
    Response<
                std::string
        >
    search(
            
            std::string q
            
    );
}; 

} 

#endif /* TINY_CPP_CLIENT_DefaultApi_H_ */