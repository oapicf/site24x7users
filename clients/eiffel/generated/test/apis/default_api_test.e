note
    description: "API tests for DEFAULT_API"
    date: "$Date$"
    revision: "$Revision$"


class DEFAULT_API_TEST

inherit

    EQA_TEST_SET

feature -- Test routines


    test_search
            -- Search with a query
            --
            -- 
        local
            l_response: STRING_32
            l_q: STRING_32
        do
            -- TODO: Initialize required params.
            -- l_q

            -- l_response := api.search(l_q)
            assert ("not_implemented", False)
        end

feature {NONE} -- Implementation

    api: DEFAULT_API
            -- Create an object instance of `DEFAULT_API'.
        once
            create { DEFAULT_API } Result
        end

end
