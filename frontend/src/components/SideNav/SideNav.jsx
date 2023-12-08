import React from 'react';

import Tippy from '@tippyjs/react';
import 'tippy.js/dist/tippy.css';
import classNames from 'classnames/bind';
import styles from './SideNav.module.scss';
import Icon from '../Icons/Icon';
import SideNavLinks from '../SideNavLinks';
import images from '~/assets/images';

const cx = classNames.bind(styles);
const SideNav = () => {
    return (
        <aside className={cx('side-nav')}>
            <img className={cx('image')} src={images.logo} alt="logo" />
            <SideNavLinks />
            <Tippy delay={[0, 40]} content="Logout" placement="right">
                <div className={cx('icon')}>
                    <Icon icon="arrow" />
                </div>
            </Tippy>
        </aside>
    );
};

export default SideNav;
