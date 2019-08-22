import axios from 'axios'

axios.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
axios.defaults.baseURL="/api/";


/**
 * Retrieve resource
 *
 * @param {url} url
 */
async function getResource(url){
    try{
        let res= await axios.get(url);
        return [null,res]
    } catch(err) {
        return [err,null]
    }
}

/**
 * Create resource
 *
 * @param {url} url
 * @param {resource} resource
 */
async function createResource(url,resource){
    console.log(resource);
    try{

        let res =await axios.post(url,resource);
        return [null,res];
    } catch (err) {
        return [err,null];

    }

}


async function updateResource(url,resource){
    try{
        let res=await  axios.patch(url,resource);
        return [null, res];
    }catch (err) {
        return [err,null]
    }
}



export {getResource,createResource,updateResource}