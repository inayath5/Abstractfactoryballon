package com.app.ballon;

enum BallonType
{
	WATERBAALLOONS, PARTYBAALLOONS, BIRTHDAYBAALLOONS, LATEXBAALLOONS,

}
abstract class Ballon {
	Ballon(BallonType model, Location location)
	{
		this.model = model;
		this.location = location;
	}
	abstract void construct();

	BallonType model = null;
	Location location = null;

	BallonType getModel()
	{
		return model;
	}
	void setModel(BallonType model)
	{
		this.model = model;
	}

	Location getLocation()
	{
		return location;
	}
	void setLocation(Location location)
	{
		this.location = location;
	}
	@Override
	public String toString()
	{
		return "Ballon type - "+model + " located in "+location;
	}
}
class LatexBallon extends Ballon
{
	LatexBallon(Location location)
	{
		super(BallonType.LATEXBAALLOONS, location);
		construct();
	}
	@Override
	protected void construct()
	{
		System.out.println("Connecting to LATEX Ballons");
	}
}

class BirthdayBallon extends Ballon
{
	BirthdayBallon(Location location)
	{
		super(BallonType.BIRTHDAYBAALLOONS , location);
		construct();
	}
	@Override
	protected void construct()
	{
		System.out.println("Connecting to BIRTHDAY Ballons");
	}
}
class PartyBallon extends Ballon
{
	PartyBallon(Location location)
	{
		super(BallonType.PARTYBAALLOONS, location);
		construct();
	}
	@Override
	protected void construct()
	{
		System.out.println("Connecting to PARTY Ballons");
	}
}
class WaterBallon extends Ballon
{
	WaterBallon(Location location)
	{
		super(BallonType.WATERBAALLOONS, location);
		construct();
	}
	@Override
	protected void construct()
	{
		System.out.println("Connecting to WATER Ballons");
	}
}
enum Location
{
	NEWYORK, CHICAGO, BOSTAN, WASHINGTON
}

class WASHINGTONFactory
{
	static Ballon buildBallon(BallonType model)
	{
		Ballon ballon = null;
		switch (model)
		{
		case WATERBAALLOONS:
			ballon = new LatexBallon(Location.NEWYORK);
			break;

		case PARTYBAALLOONS:
			ballon = new BirthdayBallon(Location.CHICAGO);
			break;

		case BIRTHDAYBAALLOONS:
			ballon = new PartyBallon(Location.BOSTAN);
			break;
		case LATEXBAALLOONS:
			ballon = new WaterBallon(Location.WASHINGTON);
			break;

		default:
			break;

		}
		return ballon;
	}
}

class BOSTANFactory
{
	static Ballon buildBallon(BallonType model)
	{
		Ballon ballon = null;
		switch (model)
		{
		case WATERBAALLOONS:
			ballon = new LatexBallon(Location.NEWYORK);
			break;

		case PARTYBAALLOONS:
			ballon = new BirthdayBallon(Location.CHICAGO);
			break;

		case BIRTHDAYBAALLOONS:
			ballon = new PartyBallon(Location.BOSTAN);
			break;
		case LATEXBAALLOONS:
			ballon = new WaterBallon(Location.WASHINGTON);
			break;

		default:
			break;

		}
		return ballon;
	}
}


class CHICAGOFactory
{
	static Ballon buildBallon(BallonType model)
	{
		Ballon ballon = null;
		switch (model)
		{
		case WATERBAALLOONS:
			ballon = new LatexBallon(Location.NEWYORK);
			break;

		case PARTYBAALLOONS:
			ballon = new BirthdayBallon(Location.CHICAGO);
			break;

		case BIRTHDAYBAALLOONS:
			ballon = new PartyBallon(Location.BOSTAN);
			break;
		case LATEXBAALLOONS:
			ballon = new WaterBallon(Location.WASHINGTON);
			break;

	

		}
		return ballon;
	}
}


class NeyorkFactory
{
	static Ballon buildBallon(BallonType model)
	{
		Ballon ballon = null;
		switch (model)
		{
		case WATERBAALLOONS:
			ballon = new LatexBallon(Location.NEWYORK);
			break;

		case PARTYBAALLOONS:
			ballon = new BirthdayBallon(Location.CHICAGO);
			break;

		case BIRTHDAYBAALLOONS:
			ballon = new PartyBallon(Location.BOSTAN);
			break;
		case LATEXBAALLOONS:
			ballon = new WaterBallon(Location.WASHINGTON);
			break;

		default:
			break;

		}
		return ballon;
	}
}


class BallonFactory
{
    private BallonFactory() 
    {
          
    }
    public static Ballon buildBallon(BallonType type)
    {
        Ballon ballon = null;
        // We can add any GPS Function here which
        // read location property somewhere from configuration
        // and use location specific car factory
        // Currently I'm just using INDIA as Location
        Location location = Location.NEWYORK; 
          
        switch(location)
        {
            case NEWYORK:
            	ballon = WASHINGTONFactory.buildBallon(type);
                break;
                  
            case CHICAGO:
            	ballon = BOSTANFactory.buildBallon(type);
                break;
                      
            case BOSTAN:
            	ballon = CHICAGOFactory.buildBallon(type);
                break;
                      
            case WASHINGTON:
            	ballon = NeyorkFactory.buildBallon(type);
               break;
                      
              
  
        }
          
        return ballon;
  
    }
}

class AbstractDesign 
{
	public static void main(String[] args)
	{
		System.out.println(BallonFactory.buildBallon(BallonType.WATERBAALLOONS));
		System.out.println(BallonFactory.buildBallon(BallonType.PARTYBAALLOONS));
		System.out.println(BallonFactory.buildBallon(BallonType.BIRTHDAYBAALLOONS));
		System.out.println(BallonFactory.buildBallon(BallonType.LATEXBAALLOONS));



	}
}
