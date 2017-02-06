package com.mygdx.game.GameObjects;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Created by alexey on 06.02.17.
 */

public class PlatformBoost {

    private Body body;
    private final float weight=0.33f;
    private final float height=0.08f;


    public PlatformBoost(Body body)
    {
        this.body=body;
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(weight,height);
        body.createFixture(poly,0);
        poly.dispose();
        body.setLinearVelocity(Platform.speed,0);

    }


    public Body getBody() {
        return body;
    }
    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public void increaseSpeed()
    {
        body.setLinearVelocity(Platform.speed,0);

    }

}
