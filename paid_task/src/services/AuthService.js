import axios from "axios";
import http from '../utils/http-common';

axios.defaults.baseURL = process.env.REACT_APP_BACKEND_SERVER;

const loginRequest = async (data) => {
	// console.log(favJSON);
	const response = await axios({
		method: 'post',
		url: `${process.env.REACT_APP_BACKEND_SERVER}/logindetails/login`,
		data: data,
		headers: {
			'Content-Type': 'application/json; charset=utf-8',
		},
	});
	// alert("Favourite created --- "+ response);
	return response;
};
const AuthService={
    loginRequest,
}

export default AuthService;