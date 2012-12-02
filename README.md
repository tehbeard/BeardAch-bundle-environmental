# BeardAch :: Environmental triggers and rewards bundle.

This package provides a number of triggers and rewards not found in the base package of BeardAch, 
centred around physical things in the game (weather, time, experience, health, lightning).

This package also serves as a reference for those developing addons for BeardAch.

## For Developers.

Triggers/Rewards must satisfy at three constraints to be usable by BeardAch. Further constraits 
while optional greatly enhance the end user experience/code clarity.

### Required:
* Trigger / Reward must implement the ITrigger / IReward interface, respectively.
* Trigger / Reward must be annotated with @Configurable(tag="tagname"), this is used in config 
  to address the Trigger / Reward (e.g. a trigger annotated with @Configurable(tag="bacon") would 
  be used if the config contained bacon|param1:param2:param3 
* A valid bundle.properties file must be in the root folder of the jar, containing the addon's 
  name and classes that implement ITrigger / IReward.

### Optional constraints:
* The @Usage tag is parsed to generate a help document detailing all Triggers and Rewards available 
  to BeardAch. It is recommended that you add this to your Trigger / Reward so that end users can
  easily find out how to use your Trigger / Reward.
* BeardAch detects if a Trigger implements Listener, and automatically registers it.
