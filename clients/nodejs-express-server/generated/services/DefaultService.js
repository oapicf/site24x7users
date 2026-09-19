/* eslint-disable no-unused-vars */
const Service = require('./Service');

/**
* Search with a query
*
* q String 
* returns String
* */
const search = ({ q }) => new Promise(
  async (resolve, reject) => {
    try {
      resolve(Service.successResponse({
        q,
      }));
    } catch (e) {
      reject(Service.rejectResponse(
        e.message || 'Invalid input',
        e.status || 405,
      ));
    }
  },
);

module.exports = {
  search,
};
