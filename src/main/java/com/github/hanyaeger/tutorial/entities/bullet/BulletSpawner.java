package com.github.hanyaeger.tutorial.entities.bullet;

import com.github.hanyaeger.api.entities.EntitySpawner;

public class BulletSpawner extends EntitySpawner {
    public BulletSpawner() {
        super(0);
    }

    @Override
    protected void spawnEntities() {

    }

    public void schiet(Bullet kogel){
        spawn(kogel);
    }


}
