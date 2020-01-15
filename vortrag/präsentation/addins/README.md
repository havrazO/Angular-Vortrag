Progress Indicator (formerly known as Progess Dots)
==================
This macro adds a ribbon to PowerPoint that can be used to create a
"progress indicator" for your presentation.  A series of shapes is drawn across
the top border, corresponding to slides; and these shapes change color
as you advance through the presentation.  The shapes can be grouped into
sections to indicate the overall structure of your talk.


Installing
----------
To install progress indicator:

- Open PowerPoint
- Under the "Tools" menu, select "Add-Ins"
- Click "Add New"
- Select the file "ProgressIndicators.ppam"
- Click "Enable Macros"

To uninstall progress indicator:

- Open PowerPoint
- Under the "Tools" menu, select "Add-Ins"
- Select the "ProgressIndicators" add-in
- Click "Remove"

How it works
------------
Hint: Take a look at the ProgressIndicators file. We prepares this not to be the macro conatiner only, but also a demo presentation with lots of explanations.

Everytime you change something in the ribbon, the progress indicator will be updated accordingly.
Settings from the ribbon will be saved as a tag to your presentation (invisible) and be read next time you open your presentation.
You can remove the progress indicators as well using the corresponding button.

The generated progress bar could look something like this:

        Intro     Topic 1        Topic 2      Conclusions
       # # # #    # # * *    * * * * * * * * *    * *



Editing
-------
If you'd like to edit the macro, to make your own customizations to
it:

- Open the file "ProgressIndicators.pptm"
- Under the "Macros" submenu of the "Tools" menu, slect "Visual Basic Editor"

History
------
The macro was originally written by Ed Loper and was available here: http://ed.loper.org/projects/progress_dots/
It has been modified to work on Office 2016 (32 and 64bit, also Office 2010 and 2013) on Windows and OS X by Olaf Nöhring ( http://www.datenbank-projekt.de ) and shared in this ( 
https://github.com/adammwilson/progress_dots ) repository.
