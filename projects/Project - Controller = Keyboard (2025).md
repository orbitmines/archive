With the thought that keyboards are less useful/portable in a VR setting:
Controller as main programming language tooling:

---

# Model Input
- Layout from the keyboard  
- Controller Input (mapped to some generic way which would work for all types of controllers)  
- Predictions from some algorithm based on joystick movement. (Mapped to locations on the keyboard)?  
- Surrounding text (before)  
- (Ignore selected text)
- Surrounding text (after)  
- Additional context in terms of project, dictionary, user-based, project-based, file type. (other contexts)  
- Probabilities given some language model  
- Currently editing text inserted after 'before', committed with clicking the left joystick (or by moving out of the context)


Fuzzing  
- Inaccurate timings: Add longer pauses between each successive change of direction.  
- Inaccurate joystick angles
- Inaccurate joystick lengths (full direction, ignoring length)
- Skip special characters
  
  
Auto generate controller input for training.  
  
How to retrain if we want additional functionality  
Is retraining necessary if we choose a new language model?

---

"The problem of translating 'usual programming language interface' to one which is more constricted'."
- Call nestedly in a variable by moving inside the object and selecting a field like that.
- .expand - Both joysticks to the outside
- .collapse - Both joysticks to the inside
- 2 cursors with both joysticks
	- Right scroll and select directionally left-right inside outside next scope. Up downis up-down next scope. Where it selects the next best thing, but moves smoothly.
- Somthing like down/trigger/bumper for voice recognition, with a quick-edit to change the result. Which hijacks usual right-joystick control?
	- Needs a good alternative if it's not possible rn
- Using AI and joysticks for word typing to move across a usual keyboard? How about less usual inputs, like repeated Q.s? RIght trigger + Right stick for where to start (NO), left trigger for a movement - it decides where to start. First entry is difficult, repeats is easier. Or quickly typing 1234567890
	- Or not right trigger but this is default behavior, right trigger to move with left joystick in another way
	- Disamiguation of manby options necessary? Left trigger up/down
	- With the idea that everybody already has a map of keyboards in their heads, so  translation should be easier: 'map' in the sense that there's at least a spatial idea of where the sequential next key is. 
	- + Approximate shift with left bumper
- Needs to take into account the style of the current user/project. 'Things like the user saying, if I do this, I mean this.'
- Space of keyboard to target input to allow easy internationalization (though certain languages might make the ambiguity of where we're pointing very difficult)
- Allow with voice to spell out words if they;'re not yet in the dictionary, use words in 'project' - being the user-level / project-level etc.., directory as more likely.
- Up is search for something (using AI bot - or normal search - both.)
- X call property
- Square, call method + right bumper: new closure
- Circle ctrl+z, ctrl+y,. or Circle + Right bumper
- triangle backspace.
- Hold left joystick - do something with current selection, and then right joystick to do things like turn a == into a !=.
- Right trigger swap between Many/Array/Graph/Tree.;
- Left trigger swap ?
- Right, is new filter block
- Left, is Jump out of current context. Like selecting text field and editing, Or should this be right joystick?
- VIEW button switch context window (files or other contexts that the right joystick doesnt have access to)
- Support for other languages, contexts.
- Left/Right bumper reserved for alternate context movements since they're 'hold down keys'
- Creating a structure definition with joysticks. Loop is quick loop around (half circle) with the stick
- Use quick voice commands as quick alterations on what was just done.. 'That's with 2 r's, and then add it to the dictionary as well for that project/context and user'. Or when it's wrong, that's only within the X project, not this one. 
- Descriube keyboard layout spatially

- What about even more restrictive interfaces like some VR controllers? Take Meta quest controllers for example, 2/3 buttons on either side instead of 4. Only one trigger/bumper instead of 2.
