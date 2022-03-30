package com.github.hanyaeger.tutorial.entities;

public interface BulletCollider {
    /**
     * Interface voor klassen die kunnen exploderen, zoals de klasse Bullet, GroteBom en Kleinebom.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */

    public void explosion();
    public int damage();
}
