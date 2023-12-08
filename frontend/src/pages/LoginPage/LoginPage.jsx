import React, { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { toast, ToastContainer } from 'react-toastify';

import classNames from 'classnames/bind';
import styles from './LoginPage.module.scss';
import { useDispatch, useSelector } from 'react-redux';
import { login } from '~/states/Auth/Action';

const cx = classNames.bind(styles);
export default function LoginPage() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [rememberMe, setRememberMe] = useState(false);
    const dispatch = useDispatch();
    const { auth } = useSelector((store) => store);
    const navigate = useNavigate();

    useEffect(() => {
        console.log(rememberMe);
    }, [rememberMe]);

    const handleSignin = async () => {
        try {
            const formData = {
                email: username,
                password,
            };

            dispatch(login(formData));

            if (auth?.user?.role === 'admin') {
                navigate('/admin');
            } else if (auth?.user?.role === 'user') {
                navigate('/');
            }
        } catch (error) {
            // toast.error(error?.message);
        }
    };
    return (
        <div className={cx('body-login')}>
            <ToastContainer />
            <div className={cx('wrapper')}>
                <div className={cx('form-box login')}>
                    <h1>Welcome Back!</h1>
                    <form id="login-form">
                        <div className={cx('input-box')}>
                            <input
                                type="text"
                                id="username"
                                name="username"
                                value={username}
                                onChange={(event) => setUsername(event.target.value)}
                                required
                            />
                            <label>Username</label>
                        </div>
                        <div className={cx('input-box')}>
                            <input
                                type="password"
                                id="password"
                                name="password"
                                value={password}
                                onChange={(event) => setPassword(event.target.value)}
                                required
                            />
                            <label>Password</label>
                        </div>

                        <div className={cx('remember-forgot')}>
                            <div>
                                <input
                                    type="checkbox"
                                    checked={rememberMe}
                                    onChange={() => setRememberMe(!rememberMe)}
                                />
                                <label>Remember me</label>
                            </div>

                            <Link to={'/forgetpassword'}>Forget Password</Link>
                        </div>
                        <button type="button" onClick={handleSignin} className={`${cx('btn')} ${cx('btn-login')}`}>
                            LOGIN
                        </button>
                        <div className={cx('login-register')}>
                            <p>
                                Don't have an account?
                                <Link to={'/register'} className={cx('register-link')}>
                                    Register
                                </Link>
                            </p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}
